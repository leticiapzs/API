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

  public String writerTeste() {

    LocalDateTime dateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo("deboramat.ipac@gmail.com");
    message.setSubject("OBRIGADA PELA SUA AVALIAÇÃO"); 
    message.setText("Obrigada por usar nossa plataforma de avaliação" + dateTime.format(formatter)); 

    try {
      javaMailSender.send(message);
      return "E-mail enviado com sucesso";
    } catch (Exception e) {
      return "Erro ao enviar e-mail" + e.getMessage();
    }

  }

  public String writerTeste2() {
      LocalDateTime dateTime = LocalDateTime.now();
      DateTimeFormatter dateForm = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

      MimeMessage message = javaMailSender.createMimeMessage();

      try {
          MimeMessageHelper helper = new MimeMessageHelper(message, true);
          helper.setSubject("Teste email2");
          helper.setTo("fredcostafernandes@gmail.com");

          String emailText = "<h1>Teste de e-mail 2</h1>" + "<p>Testando...</p>" + "<p>E-mail enviado na data: "
                  + dateTime.format(dateForm) + "</p>" + "<br>";
          helper.setText(emailText, true);
          javaMailSender.send(message);
          return "Email enviado com sucesso";
      } catch (MessagingException e) {
          return "erro ao enviar o email" + e.getMessage();
      }
  }

  public void mailSend() {
      
      LocalDateTime dateTime = LocalDateTime.now();
      DateTimeFormatter dateForm = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
      
      DecimalFormat df = new DecimalFormat("R$ #,##0.00");
      
      MimeMessage message = javaMailSender.createMimeMessage();
      
      try {
      MimeMessageHelper helper = new MimeMessageHelper(message,true);
      helper.setSubject("Atores Relevantes");
      helper.setTo("rofred1430@gmail.com");
      
      StringBuilder sBuilder = new StringBuilder();
      sBuilder.append("<html>\r\n");
      sBuilder.append("    <body>\r\n");
      sBuilder.append(dateTime.format(dateForm));
      sBuilder.append("        <div align=\"center\">\r\n");
      sBuilder.append("            <h1>Filmes</h1>\r\n");
      sBuilder.append("        </div>\r\n");
      sBuilder.append("        <br>\r\n");
      sBuilder.append("        <table border='2' cellpadding='2'>\r\n");
      sBuilder.append("            <tr><th>Filme</th><thPreço</th></tr>\r\n");
      sBuilder.append("            <tr><td>O diabo veste prada</td><td>"+df.format(59.90)+"</td></tr>\r\n");
      sBuilder.append("            <tr><td>5 mulheres e um segredo</td><td>"+df.format(49.99)+"</td></tr>\r\n");
      sBuilder.append("        </table>\r\n");
      sBuilder.append("    </body>\r\n");
      sBuilder.append("</html>");
      
      helper.setText(sBuilder.toString(),true);
      
      javaMailSender.send(message);

      } catch (MessagingException e) {
          System.out.print("Erro ao enviar o email" + e.getMessage());
      }
      
  }
}
