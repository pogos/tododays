package pl.pogos.tododays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.pogos.tododays.model.Tag;
import pl.pogos.tododays.repository.TagRepository;

import javax.inject.Inject;

/**
 * Created by SG0952928 on 2016-04-18.
 */
@Service
public class TagService {


    @Inject
    private TagRepository tagRepository;

    public Tag getTagByName(String name) {
        return null;
    }

    @Transactional
    public Tag createTag(String tagName) {
        Tag tag = new Tag(tagName);
        return tagRepository.save(tag);
    }

    @Transactional
    public Tag findById(Long tagId) {
        Tag one = tagRepository.findOne(tagId);
        return one;
    }
}
