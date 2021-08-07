/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.PNUFDSA.Service;

import fdsa.edu.PNUFDSA.Model.Message;
import fdsa.edu.PNUFDSA.Repository.MessageDAO;
import java.util.Optional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Richard
 */

@Data
@Service

public class MessageService {
    
    @Autowired
    
     private MessageDAO messageDAO;
    
    public Optional<Message> getMessage(final int id) {
        return messageDAO.findById(id);
    }
    
     public Iterable<Message> getMessage() {
        return messageDAO.findAll();
    }

    public void deleteMessage(final int id) {
        messageDAO.deleteById(id);
    }

    public Message saveMessage(Message Message) {
        Message savedMessage = messageDAO.save(Message);
        return savedMessage;
    }
    
}
