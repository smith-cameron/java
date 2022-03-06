@Controller
public class TheController {
	@Autowired
	private ExpenseService eService;
	
	@GetMapping("/")
	public String rootRoute(@ModelAttribute("newExpense")Expense expenseInput, Model viewModel){
		viewModel.addAttribute("expenses", this.eService.getAll());
		return "index.jsp";
	}
	@PostMapping("/create")
	public String createExpense(@Valid @ModelAttribute("newExpense")Expense expenseInput, BindingResult result, Model viewModel) {
		if (result.hasErrors()) {
			viewModel.addAttribute("expenses", this.eService.getAll());
			return "index.jsp";
		}
		this.eService.create(expenseInput);
		return "redirect:/";
	}
}
