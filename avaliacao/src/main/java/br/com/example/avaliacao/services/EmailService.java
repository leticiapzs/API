package br.com.example.avaliacao.services;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component
public class EmailService {

  @Autowired
  public JavaMailSender javaMailSender;

  @Value("${spring.mail.username}")
  private String emailRemetente;

  @Value("${spring.mail.host}")
  private String emailServerHost;

  @Value("${spring.mail.port}")
  private Integer emailServerPort;

  @Value("${spring.mail.password}")
  private String emailPassword;

  public JavaMailSender javaMailSender() {
    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    mailSender.setUsername(emailRemetente);
    mailSender.setHost(emailServerHost);
    mailSender.setPort(emailServerPort);
    mailSender.setPassword(emailPassword);

    Properties props = mailSender.getJavaMailProperties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");

    return mailSender;
  }

  public String writerTeste() {

    LocalDateTime dateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo("fredcostafernandes@gmail.com");
    message.setSubject("TESTE"); 
    message.setText("Testando o envio do email" + dateTime.format(formatter)); 

    try {
      javaMailSender.send(message);
      return "E-mail enviado com sucesso";
    } catch (Exception e) {
      return "Erro ao enviar e-mail" + e.getMessage();
    }

  }

  public String writerTeste2() {

    LocalDateTime dateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    MimeMessage message = javaMailSender.createMimeMessage();

    try {
      MimeMessageHelper helper = new MimeMessageHelper(message, true);
      helper.setTo("fredcostafernandes@gmail.com");
      helper.setSubject("Ofertas Especiais para Você!"); 

      String html = "<p>Ofertas Especiais para você!</p>";
      helper.setText(html, true); 
      javaMailSender.send(message);
      return "E-mail enviado com sucesso";
    } catch (MessagingException e) {
      return "Erro ao enviar e-mail" + e.getMessage();
    }

  }

}
