public class Dorm {
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
	@NotBlank
	@Size(min=2, max=255, message="Must be 2-255 characters")
	private String name;
//	Table Relationships ----------------------------------------------------
	@OneToMany(mappedBy="dorm", fetch = FetchType.LAZY, orphanRemoval=true)
    private List<Student> students;
}
