public class Student {
    @Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(updatable=false)
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date createdAt;
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date updatedAt;
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	}
	@NotBlank(message="Name Required")
	@Size(min=2, max=255, message="Must be 2-255 characters")
	private String firstName;
	@NotBlank(message="Name Required")
	@Size(min=2, max=255, message="Must be 2-255 characters")
	private String lastName;
	@NotNull(message="Age Required")
	@Min(value=18, message="Must be older than 18")
	private int age;
//	Table Relationships ----------------------------------------------------
	@OneToOne(mappedBy="student", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private Contact contact;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dorm_id")
    private Dorm dorm;
}
