package com.nevitech.allianz.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "allianz")
public class campaign {

	@Id
	private String id;
	@Column(name = "name")
	private String name;
	@Column(name = "details")
	private String detail;
	@Column(name = "state")
	private String Status;
	@Column(name = "Category")
	private String Category;
	private Boolean mukerrer = false;
	

	public campaign(@JsonProperty("detail") String Detail, @JsonProperty("name") String name,
			@JsonProperty("category") String Category) {
		this.id = UUID.randomUUID().toString();
		// isim kontrol
		if (namecheck(name) == true)
			this.name = name;
		else
			throw new IllegalArgumentException("İsim kriterlere uymuyor.");
		// detay açıklama kontrol
		if (detailcheck(Detail) == true)
			this.detail = Detail;
		else
			throw new IllegalArgumentException("Açıklama kriterlere uymuyor.");

		// kategori ve durum atama
		if (Category.toLowerCase().compareTo("tamamlayıcı sağlık sigortası") == 0) {
			this.Category = "tamamlayıcı sağlık sigortası";
			this.Status = "waiting";

		} else if (Category.toLowerCase().compareTo("özel sağlık sigortası") == 0) {
			this.Category = "özel sağlık sigortası";
			this.Status = "waiting";

		} else if (Category.toLowerCase().compareTo("hayat sigortası") == 0) {
			this.Category = "hayat sigortası";
			this.Status = "active";

		} else if (Category.toLowerCase().compareTo("diğer") == 0) {
			this.Category = "diğer";
			this.Status = "waiting";


		} else {
			
			throw new IllegalArgumentException("Sigorta kategorisi bulunamadı.");
		}

	}

	public campaign(campaign Campaign) {

		this.id = UUID.randomUUID().toString();
		// isim kontrol
		if (namecheck(Campaign.name) == true)
			this.name = Campaign.name;
		else
			throw new IllegalArgumentException("İsim kriterlere uymuyor.");
		// detay açıklama kontrol
		if (detailcheck(Campaign.getDetail()) == true)
			this.detail = Campaign.getDetail();
		else
			throw new IllegalArgumentException("Açıklama kriterlere uymuyor.");


		// kategori ve durum atama
		if (Campaign.Category.toLowerCase().compareTo("tamamlayıcı sağlık sigortası") == 0) {
			this.Category = "tamamlayıcı sağlık sigortası";
			this.Status = "waiting";

		} else if (Campaign.Category.toLowerCase().compareTo("özel sağlık sigortası") == 0) {
			this.Category = "özel sağlık sigortası";
			this.Status = "waiting";

		} else if (Campaign.Category.toLowerCase().compareTo("hayat sigortası") == 0) {
			this.Category = "hayat sigortası";
			this.Status = "active";

		} else if (Campaign.Category.toLowerCase().compareTo("diğer") == 0) {
			this.Category = "diğer";
			this.Status = "waiting";


		} else {
			
			throw new IllegalArgumentException("Sigorta kategorisi bulunamadı.");
		}
	}

	public campaign() {

	}

	public String getid() {
		return id;
	}

	public void setid(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	
	public String getCategory() {
		return Category;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		if (mukerrer == false)
			Status = status;
	}


	public void setCategory(String Category) {
		if (Category.toLowerCase().compareTo("tamamlayıcı sağlık sigortası") == 0) {
			this.Category = "tamamlayıcı sağlık sigortası";
			

		} else if (Category.toLowerCase().compareTo("özel sağlık sigortası") == 0) {
			this.Category = "özel sağlık sigortası";
			

		} else if (Category.toLowerCase().compareTo("hayat sigortası") == 0) {
			this.Category = "hayat sigortası";
			
		} else if (Category.toLowerCase().compareTo("diğer") == 0) {
			this.Category = "diğer";
		


		} else {
			
			throw new IllegalArgumentException("Sigorta kategorisi bulunamadı.");
		}
	}

	public Boolean getMukerrer() {
		return mukerrer;
	}

	public void setMukerrer(Boolean mukerrer) {
		this.mukerrer = mukerrer;
	}

	private boolean namecheck(String name) {
		if (name == null || name.isEmpty())
			return false;

		char firstletter = name.charAt(0);
		if ((firstletter >= 'A' && firstletter <= 'Z') || (firstletter >= 'a' && firstletter <= 'z')
				|| firstletter >= '0' && firstletter <= '9') // ascii ile harf ve digit kontrol
			return true;

		if ((firstletter >= '\u0041' && firstletter <= '\u007A') || (firstletter >= '\u00C0' && firstletter <= '\u00FF')
				|| (firstletter >= '\u011E' && firstletter <= '\u0131')
				|| (firstletter >= '\u015E' && firstletter <= '\u015F')
				|| (firstletter >= '\u0160' && firstletter <= '\u017F')) // unicode türkçe karakter kontrolü
			return true;
		if (name.length() > 50 || name.length() < 10)
			return false;
		else
			return true;
	}

	private boolean detailcheck(String detail) {
		if (detail == null || detail.isEmpty())
			return false;
		if (detail.length() > 200 || detail.length() < 20)
			return false;

		return true;
	}

}



