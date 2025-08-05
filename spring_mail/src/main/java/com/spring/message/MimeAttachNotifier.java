package com.spring.message;

import java.io.File;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.spring.command.MailRequest;

public class MimeAttachNotifier {

	
	private JavaMailSender mailSender;
	public MimeAttachNotifier(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public void sendMail(MailRequest command, String uploadPath) throws Exception {
		// 메시지 생성
		MimeMessage message = mailSender.createMimeMessage();
		// 메시지 작성 헬퍼.
		MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "utf-8");
		
		// 받는사람
		messageHelper.setTo(new InternetAddress(command.getReceiver()));
		// 보내는사람
		messageHelper.setFrom(command.getSender(), "운영자");
		// 제목
		messageHelper.setSubject(command.getTitle());
		// 내용
		messageHelper.setText(command.getContent(), true);
		// 첨부파일
		if (command.getFile() != null && !command.getFile().isEmpty()) {
			String fileName = command.getFile().getOriginalFilename();
			DataSource dataSource = new FileDataSource(new File(uploadPath, fileName));
			messageHelper.addAttachment(MimeUtility.encodeText(fileName, "utf-8", "B"), 
										dataSource);
		}
		
		// 메일 보내기.
		mailSender.send(message);
	}
	
}




