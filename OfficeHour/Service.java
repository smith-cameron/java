@Service
public class Service {
	@Autowired
	private UserRepo repo;
	
	public User create(User newEntry) {
		return this.repo.save(newEntry);
	}
	public User update(User toUpdate) {
		return this.repo.save(toUpdate);
	}
	public List<User> getAll(){
		return this.repo.findAll();
	}
	public User getById(Long id) {
		return this.repo.findById(id).orElse(null);
	}
	public void deleteById(Long id) {
		this.repo.deleteById(id);
	}

}