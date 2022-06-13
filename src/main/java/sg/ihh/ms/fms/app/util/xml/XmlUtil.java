package sg.ihh.ms.fms.app.util.xml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlUtil {

    @Autowired
    private static XmlMapper objMapper;

    private static final Logger log = LoggerFactory.getLogger(XmlUtil.class);

    private XmlUtil() {}

    public static String toXml(Object obj) {
        try {
            return objMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("toXml", e);
        }
        return "";
    }
}
