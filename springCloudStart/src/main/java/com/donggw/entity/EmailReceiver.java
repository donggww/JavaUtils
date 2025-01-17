package com.donggw.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "EMAIL_RECEIVER")
public class EmailReceiver {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AUTINC_ID")
	private Long autincId;

	@Column(name = "NAME", length = 256)
	private String name;

	@Column(name = "EMAIL", length = 256)
	private String email;

	@Column(name = "TEL", nullable = false, length = 14)
	private String tel;

	@Column(name = "STATUS", nullable = false, length = 4)
	private String status;

	@Column(name = "CREATE_TIME", nullable = false, updatable = false)
	@org.hibernate.annotations.CreationTimestamp
	private Date createTime;

	@Column(name = "UPDATE_TIME")
	@org.hibernate.annotations.UpdateTimestamp
	private Date updateTime;

}
