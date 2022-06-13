package sg.ihh.ms.fms.app.repository;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Query;
import org.springframework.stereotype.Repository;

import sg.ihh.ms.fms.app.gw.model.EmailTemplate;

@Repository
public class EmailTemplateRepository extends BaseRepository {

    public EmailTemplateRepository() {
        log = getLogger(getClass());
    }

    public EmailTemplate getTemplate(String templateName) {
        final String methodName = "getTemplate";
        start(methodName);

        EmailTemplate template = new EmailTemplate();

        final String sql =  "SELECT uid, name, sender, recipients, subject, template " +
                            "FROM email_template " +
                            "WHERE name = :name";

        log.info(templateName);
        try (Handle handle = getHandle(); Query query = handle.createQuery(sql)) {
            query.bind("name", templateName);

            template = query.mapToBean(EmailTemplate.class).first();
        } catch (Exception e) {
            log.error(methodName, e.getMessage());
        }

        completed(methodName);
        return template;
    }
}
