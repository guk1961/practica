package ru.adedit.cron.service.mail;

import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

public class IssueMailManager implements MailManager {
	
	private JavaMailSender mailSender;
	private VelocityEngine velocityEngine;
//	Properties props = new Properties();
	Console con = System.console();

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}
	
	public static String dateToString(Date a_date, String a_dateFormat) {
	    SimpleDateFormat sdf = new SimpleDateFormat(a_dateFormat);
	    return sdf.format(a_date);
	 }
	
	@Override
	public void sendMail(final Map model) {
//	    props.put(Velocity.INPUT_ENCODING, "utf-8");
//	    props.put(Velocity.OUTPUT_ENCODING, "utf-8");
//	    Velocity.init(props);

	    MimeMessagePreparator preparator = new MimeMessagePreparator() {
			
			String msg="Это сообщение о переводе номеров";

			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo("guk@d-mir.ru");
				message.setFrom("ferum@d-mir.ru"); // could be parameterized...
				message.setSubject("Автоматический перевод номеров");
	//			Map model = new HashMap();
				model.put("msg", msg);
//				velocityEngine.setProperty(VelocityEngine.INPUT_ENCODING, "UTF-8");
//				velocityEngine.setProperty(VelocityEngine.OUTPUT_ENCODING, "UTF-8");
				String text = VelocityEngineUtils.mergeTemplateIntoString(
						velocityEngine, "ru/adedit/cron/nextIssue.vm","UTF-8", model);
					message.setText(text, true);
			}
		};
//			this.mailSender.setDefaultEncoding("utf-8");
			this.mailSender.send(preparator);
//			con.printf("письмо отправлено..."+dateToString(new Date(), "dd.MM.yy HH:mm:ss:SSS"));
			System.out.println("письмо отправлено..."+dateToString(new Date(), "dd.MM.yy HH:mm:ss:SSS"));
	}

}
