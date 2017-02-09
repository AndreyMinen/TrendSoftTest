package ru.dronix.trendsoftest.models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ADMIN on 08.02.2017.
 */
@Entity
@Table(name = "news")
public class News {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "descr")
    private String descr;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_publish")
    private Date date_publish;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category_id;

    public News() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Date getDate_publish() {
        return date_publish;
    }

    public void setDate_publish(Date date_publish) {
        this.date_publish = date_publish;
    }

    public Category getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Category category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", descr='" + descr + '\'' +
                ", date_publish=" + date_publish +
                ", category_id=" + category_id +
                '}';
    }


}
