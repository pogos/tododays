package pl.pogos.tododays.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.pogos.tododays.config.DatabaseConfiguration;
import pl.pogos.tododays.config.ServiceConfiguration;
import pl.pogos.tododays.model.Tag;
import pl.pogos.tododays.repository.TagRepository;

import javax.inject.Inject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {DatabaseConfiguration.class, ServiceConfiguration.class})
@WebAppConfiguration
public class TagServiceTest {

    @Inject
    TagService tagService;

    @Inject
    TagRepository tagRepository;

    @Test
    public void shouldCreateTag() {
        //GIVEN
        final String tagName = "Tag 1";

        //WHEN
        Tag tag = tagService.createTag(tagName);

        //THEN
        assertThat(tag, notNullValue());
        Long tagId = tag.getId();
        assertThat(tagId, notNullValue());
        assertThat(tag.getTag(), equalTo(tagName));

        Tag tagFromRepo = tagRepository.findOne(tagId);
        assertThat(tagFromRepo, notNullValue());
        assertThat(tagId, equalTo(tagFromRepo.getId()));
        assertThat(tagFromRepo.getTag(), equalTo(tagName));
    }
}