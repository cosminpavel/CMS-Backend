package com.ubb.cms.services;

import com.ubb.cms.model.ConferenceSession;
import com.ubb.cms.model.Edition;
import com.ubb.cms.model.Paper;
import com.ubb.cms.model.User;
import com.ubb.cms.model.utils.PaperStatus;
import com.ubb.cms.repository.PaperRepository;
import com.ubb.cms.services.validator.EntityValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Marius Adam
 */
@Service
public class PaperService {
    private EntityValidator validator;
    private PaperRepository paperRepository;

    @Autowired
    public PaperService(EntityValidator validator, PaperRepository paperRepository) {
        this.validator = validator;
        this.paperRepository = paperRepository;
    }

    public Integer add(String title, String topic, User author, Edition edition, ConferenceSession session, PaperStatus status) {
        Paper paper = new Paper(
                session,
                author,
                edition,
                status,
                title,
                topic
        );
        validator.validate(paper);
        return (Integer) paperRepository.save(paper);
    }
}
