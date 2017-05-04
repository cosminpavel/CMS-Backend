package com.ubb.cms.services;

import com.ubb.cms.model.Conference;
import com.ubb.cms.model.Edition;
import com.ubb.cms.repository.EditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Raul on 26/04/2017.
 */
@Service
public class EditionService {

    private EditionRepository editionRepository;

    @Autowired
    public EditionService(EditionRepository editionRepository)
    {
        this.editionRepository = editionRepository;
    }

    public List<Edition> getAll()
    {
        return editionRepository.getAll();

    }


    public void addEdition(int id, Conference conference, Date beginningDate, Date endingDate, String name, Date paperSubmissionDeadline, Date finalDeadline)
    {
        editionRepository.add(new Edition(id, conference, beginningDate, endingDate, name, paperSubmissionDeadline, finalDeadline));
    }

    public void deleteUser(int key)
    {
        editionRepository.delete(key);
    }

    public Edition findById(int key)
    {
        return editionRepository.findById(key);
    }



}
