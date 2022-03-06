public interface ExpenseRepo extends CrudRepository<Expense, Long>{
	List<Expense> findAll();

}