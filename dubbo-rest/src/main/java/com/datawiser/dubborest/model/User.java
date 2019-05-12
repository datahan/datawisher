package com.datawiser.dubborest.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class User implements Serializable {

    private String id;
    private String name;
    // 注意顺序，当配置完XmlJavaTypeAdapter后，JsonSerialize可以省略
    @JsonSerialize
    @XmlJavaTypeAdapter(value = DateFormat.class)
    private Date birthday = new Date();

    public User() {
    }

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public static class DateFormat extends XmlAdapter<String, Date> {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        @Override
        public Date unmarshal(String v) throws Exception {
            return sdf.parse(v);
        }

        @Override
        public String marshal(Date v) throws Exception {
            return sdf.format(v);
        }
    }

    public static class DateJsonSerializer extends JsonSerializer<Object> {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        @Override
        public void serialize(Object date, JsonGenerator jsonGenerator,
                              SerializerProvider serializerProvider) throws IOException {

            if (date instanceof String) {
                jsonGenerator.writeString(date.toString());
            } else {
                jsonGenerator.writeString(sdf.format(date));
            }
        }
    }
}
