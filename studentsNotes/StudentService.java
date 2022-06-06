public class StudentService {
    @Autowired
	private StudentRepo sRepo;
	
	public Student create(Student newEntry) {
		return this.sRepo.save(newEntry);
	}
	public Student update(Student toUpdate) {
		return this.sRepo.save(toUpdate);
	}
	public List<Student> getAll(){
		return this.sRepo.findAll();
	}
	public Student getById(Long id) {
		return this.sRepo.findById(id).orElse(null);
	}
	public void deleteById(Long id) {
		this.sRepo.deleteById(id);
	}
	public Dorm getDorm(Student student) {
		Dorm thisDorm = student.getDorm();
		return thisDorm;
	}
	public void setDorm(Long student, Dorm dorm) {
		Student thisStudent = this.getById(student);
		thisStudent.setDorm(dorm);
		this.sRepo.save(thisStudent);
	}
	public void removeDorm(Student student) {
		student.setDorm(null);
		//this.create(student);
		this.sRepo.save(student);
	}
}
