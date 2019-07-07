package fr.ncg.mygardenguardian.dto;

public class EventCalendarDTO {

	public Integer id;

	public String title;

	public boolean allDay;

	public String start;

	public String end;

	public EventCalendarDTO() {
	}

	public EventCalendarDTO(Integer id, String title, boolean allDay, String start, String end) {
		this.id = id;
		this.title = title;
		this.allDay = allDay;
		this.start = start;
		this.end = end;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isAllDay() {
		return this.allDay;
	}

	public void setAllDay(boolean allDay) {
		this.allDay = allDay;
	}

	public String getStart() {
		return this.start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return this.end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "EventCalendarDTO [id=" + this.id + ", title=" + this.title + ", allDay=" + this.allDay + ", start="
				+ this.start + ", end=" + this.end + "]";
	}

}
