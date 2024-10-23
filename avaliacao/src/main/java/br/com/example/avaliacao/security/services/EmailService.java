package br.com.example.avaliacao.security.services;
import java.text.DecimalFormat;
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
import org.springframework.stereotype.Service;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
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

  public String envioEmail() {

    LocalDateTime dateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo("deboramat.ipac@gmail.com");
    message.setSubject("OBRIGADA PELA SUA AVALIAÇÃO"); 
    message.setText("Sua avaliação foi registrar! Obrigada por usar nossa plataforma." + dateTime.format(formatter)); 

    try {
      javaMailSender.send(message);
      return "E-mail enviado com sucesso";
    } catch (Exception e) {
      return "Erro ao enviar e-mail" + e.getMessage();
    }

  }
}
