public class DormService {
    @Autowired
	private DormRepo dRepo;
	
	public Dorm create(Dorm newEntry) {
		return this.dRepo.save(newEntry);
	}
	public Dorm update(Dorm toUpdate) {
		return this.dRepo.save(toUpdate);
	}
	public List<Dorm> getAll(){
		return this.dRepo.findAll();
	}
	public Dorm getById(long id) {
		return this.dRepo.findById(id).orElse(null);
	}
	public void deleteById(Long id) {
		this.dRepo.deleteById(id);
	}
}
