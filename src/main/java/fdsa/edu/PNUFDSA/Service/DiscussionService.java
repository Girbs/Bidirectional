/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.PNUFDSA.Service;

import fdsa.edu.PNUFDSA.Model.Discussion;
import fdsa.edu.PNUFDSA.Repository.DiscussionDAO;
import java.util.Optional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author EstherA
 */
@Data
@Service
public class DiscussionService {
         @Autowired
    private DiscussionDAO discussionDAO;

    public Optional<Discussion> getDiscussion(final int id) {
        return discussionDAO.findById(id);
    }

    public Iterable<Discussion> getDiscussion() {
        return discussionDAO.findAll();
    }

    public void deleteDiscussion(final int id) {
        discussionDAO.deleteById(id);
    }

    public Discussion saveDiscussion(Discussion Discussion) {
        Discussion savedDiscussion = discussionDAO.save(Discussion);
        return savedDiscussion;
    }
}
