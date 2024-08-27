package mail.sender.Learing.controller;

import mail.sender.Learing.model.EmailRequest;
import mail.sender.Learing.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;
    @RequestMapping("/welcome")
    public String welcome(){
        return "hello, this is my email api";
    }

    @RequestMapping(value="/sendmail",method = RequestMethod.POST)
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request)
    {

        System.out.println(request);
        boolean result=this.emailService.sendEmail(request.getSubject(), request.getMessage(), request.getTo());
        if (result){
           return ResponseEntity.ok("done...");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("not sent...");
        }
    }

}
