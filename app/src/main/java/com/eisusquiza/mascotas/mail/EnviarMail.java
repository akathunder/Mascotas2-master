package com.eisusquiza.mascotas.mail;

/**
 * Created by eisusquiza on 02/12/2016.
 */

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.eisusquiza.mascotas.Config;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EnviarMail extends AsyncTask<Void, Void, Void> {

    //Declaring Veriables
    private Context context;
    private Session session;

    //Information to send mail
    private String email;
    private String subject;
    private String message;

    //Progressdiaglos to show while sending email
    private ProgressDialog progressDialog;

    //Class Constructor
    public EnviarMail (Context context, String email, String subject, String message){
        this.context = context;
        this.email= email;
        this.subject=subject;
        this.message=message;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //Showing progress dialog while sending email
        progressDialog = ProgressDialog.show(context,"Sending message","Please wait...",false,false);
    }
   @Override
   protected void onPostExecute(Void aVoid) {
       super.onPostExecute(aVoid);
       progressDialog.dismiss();
        Toast.makeText(context,"Mensaje Enviado", Toast.LENGTH_LONG).show();
    }



    @Override
    protected Void doInBackground(Void... params) {
        Properties props = new Properties();

        //Configuring proporties for gmail
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        //Creating a new session
        session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    //Authenticating the password
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(Config.EMAIL, Config.PASSWORD);
                    }
                });
        try {
            //Creating MimeMessage object
            MimeMessage mm = new MimeMessage(session);

            //Setting sender address
            mm.setFrom(new InternetAddress(Config.EMAIL));
            //Adding receiver
            mm.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            //Adding subject
            mm.setSubject(subject);
            //Adding message
            mm.setText(message);

            //Sending email
            Transport.send(mm);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }
}





