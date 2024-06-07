package com.ensa.spring.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"contributions"})
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    private String name;
    private Double budget;

    @OneToMany(mappedBy ="project", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Contribution> contributions=new ArrayList<>();

    public Project(String name, Double budget) {
        this.name = name;
        this.budget = budget;
    }
    public void addContribution(Contribution contribution){
        contributions.add(contribution);
        contribution.setProject(this);
    }
    @Override
    public String toString() {
        return "Project[id=" + id + "]";
    }
}
