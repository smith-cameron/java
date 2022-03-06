@Service
public class ExpenseService {
	@Autowired
	private ExpenseRepo eRepo;
	
	public Expense create(Expense newEntry) {
		return this.eRepo.save(newEntry);
	}
	public Expense update(Expense toUpdate) {
		return this.eRepo.save(toUpdate);
	}
	public List<Expense> getAll(){
		return this.eRepo.findAll();
	}
	public Expense getById(Long id) {
		return this.eRepo.findById(id).orElse(null);
	}
	public void deleteById(Long id) {
		this.eRepo.deleteById(id);
	}

}