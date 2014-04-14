package ru.adedit.cron.service.mail;

import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;

public class SimpleIssueManager implements IssueManager {

	private MailSender mailSender;
	private SimpleMailMessage templateMessage;
	
	
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	public void setTemplateMessage(SimpleMailMessage templateMessage) {
		this.templateMessage = templateMessage;
	}
	
	Console con = System.console();

	@Override
	public void setIssue(String text) {
		
		SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
//		msg.setTo("guk@d-mir.ru");
//		msg.setTo("gukers@yandex.ru");
//		msg.setTo("guk1961@gmail.com");
		msg.setTo("yukkar@mail.ru");
		msg.setText(text);
//		System.out.println("сообщение отправлено");
		try{
			this.mailSender.send(msg);
			con.printf("E-mail отправлен..."+"\n");
		}
		catch(MailException ex) {
			System.err.println(ex.getMessage());
		}
	}

	public static void main(String[] args) throws MessagingException{
		String host	=	"172.16.1.2";
		String from	=	"ferum@d-mir.ru";
		String to	=	"guk@d-mir.ru";
//		String message="";
		String subj="Привет ХТМЛ мейл =))))))";
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		sender.setHost("mail.host.com");
		sender.setDefaultEncoding("utf-8");
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
//		helper.setTo("test@host.com");
//		message.setText("Привет", "utf-8");
		
//		helper.setText("<html><head><title>CRON PROTON</title><meta http-equiv="+'"'+"content-type"+'"'+" content="+'"'+"text/html; charset=utf-8"+'"'+"/></head><body>" +
//				" <h1>Заголовок!!!</h1></body></html>",true);
		helper.setText("<html> <h1>Тестик  Заголовок!!! </h1></html>",true);
		helper.setFrom(from);
		helper.setTo(to);
		sender.setHost(host);
		message.setSubject(subj);
		sender.send(message);
//		text/plain; charset=utf-8


//		SimpleIssueManager sim = new SimpleIssueManager();
//		SimpleMailMessage smm = new SimpleMailMessage();
//		JavaMailSenderImpl ms = new JavaMailSenderImpl();
//		ms.setHost("172.16.1.2");
//		smm.setSubject("Перевод номеров");
//		smm.setFrom("ferum@d-mir.ru");
////		smm.setFrom("dmadmin@d-mir.ru");
//		sim.setTemplateMessage(smm);
//		sim.setMailSender(ms);
//		sim.setIssue("привет из спринга!");
	}
}
