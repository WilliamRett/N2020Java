package br.com.fiap.bots.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Bot implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_bot;
	private String name;
	private String welcome_msg;
	private String farewell_msg;
	private int downtime;
	private String default_answer;
	
	@OneToMany(mappedBy = "bot")
	private List<Segment> segment = new ArrayList<>();



	public List<Segment> getSegment() {
		return segment;
	}

	public void setSegment(List<Segment> segment) {
		this.segment = segment;
	}

	public long getId_bot() {
		return id_bot;
	}

	public void setId_bot(long id_bot) {
		this.id_bot = id_bot;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWelcome_msg() {
		return welcome_msg;
	}

	public void setWelcome_msg(String welcome_msg) {
		this.welcome_msg = welcome_msg;
	}

	public String getFarewell_msg() {
		return farewell_msg;
	}

	public void setFarewell_msg(String farewell_msg) {
		this.farewell_msg = farewell_msg;
	}

	public int getDowntime() {
		return downtime;
	}

	public void setDowntime(int downtime) {
		this.downtime = downtime;
	}

	public String getDefault_answer() {
		return default_answer;
	}

	public void setDefault_answer(String default_answer) {
		this.default_answer = default_answer;
	}

}
