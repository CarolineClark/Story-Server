
package io.liney.storytree;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Storyline {

	private @Id @GeneratedValue Long id;
	private String position;
	private String page;
	private String text;

	private Storyline() {}

	public Storyline(String firstName, String position, String page) {
		this.text = firstName;
		this.position = position;
		this.page = page;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}