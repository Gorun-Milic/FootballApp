package com.gorun.demo.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the coachnation database table.
 * 
 */
@Entity
@NamedQuery(name="Coachnation.findAll", query="SELECT c FROM Coachnation c")
public class Coachnation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int coachnationid;

	//bi-directional many-to-one association to Coach
	@ManyToOne
	@JoinColumn(name="coachid")
	private Coach coach;

	//bi-directional many-to-one association to Nation
	@ManyToOne
	@JoinColumn(name="nationid")
	private Nation nation;

	public Coachnation() {
	}

	public int getCoachnationid() {
		return this.coachnationid;
	}

	public void setCoachnationid(int coachnationid) {
		this.coachnationid = coachnationid;
	}

	public Coach getCoach() {
		return this.coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}

	public Nation getNation() {
		return this.nation;
	}

	public void setNation(Nation nation) {
		this.nation = nation;
	}

}