package ch.zli.m223.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Place")
public class Place {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private double story;

    @Column(nullable = true)
    private boolean isbooked;

    @OneToMany(mappedBy = "place")
    @JsonIgnoreProperties("place")
    private Set<Booking> booking;

    @OneToMany(mappedBy = "place")
    @JsonIgnoreProperties("place")
    private Set<Extra> extra;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getStory() {
        return story;
    }

    public void setStory(double story) {
        this.story = story;
    }

    public boolean isBooked() {
        return isbooked;
    }

    public void setBooked(boolean isbooked) {
        this.isbooked = isbooked;
    }

    
}
