@Entity
@Table(name="expenses")
public class Expense {
//	Attributes -------------------------------------------
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
	private String expenseName;
	@NotBlank(message="Vendor Required")
	@Size(min=2, max=255, message="Must be 2-255 characters")
	private String vendor;
	@NotNull(message="Cost Required")
	@DecimalMin(value = "0.1", inclusive = true)
	@DecimalMax(value = "999999.9", inclusive = true)
	private BigDecimal cost;
	@NotBlank(message="Description Required")
	@Size(min=2, max=255, message="Must be 2-255 characters")
	private String description;
//	Constructor -----------------------------------------
	
//	Getter/Setter Pairs ---------------------------------
	
	
	
}