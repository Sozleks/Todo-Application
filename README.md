# Проект: «Todo Application»
### 📄 Краткое описание:
- Обрабатывает входящие POST, DELETE и GET запросы с помощью REST API.
### ✔️ Ключевые возможности:
1. Возвращает весь список задач;
2. Добавляет новую задачу с автоматическим полем id;
3. Удаляет задачу по указанному id.
### 📷 Демонстрация работы:
- Процесс запуска проекта в cmd:
![Запуск проекта](Run.PNG)
- Отправка POST-запроса через Postman:
![POST-запрос](POST.PNG)
- Отправка GET-запроса через Postman:
![POST-запрос](GET.PNG)
- Отправка DELETE-запроса через Postman:
![POST-запрос](DELETE.PNG)
### ⚙️ Элементы кода:
- Объект для автоматического создания таблицы (Task.java):
```java
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private boolean completed;

    public Task() {}

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public boolean isCompleted() { return completed; }

    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}
```
- Интерфейс для автоматической генерации SQL-запросов (TodoRepository.java):
```java
public interface TodoRepository extends JpaRepository<Task, Long> { }
```
- Обработка запросов (TaskController.java):
```java
@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TodoRepository repository;

    public TaskController(TodoRepository repository) {
        this.repository = repository;
    }

    // Get all tasks
    @GetMapping
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    // Create new task
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return repository.save(task);
    }

    // Delete task by id
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
```
### 📊 Минимальные системные треования:
- Аппаратные:
  1. ОЗУ - 4 Гб.;
  2. Процессор: Intel Core (i3/i5/i7), AMD Ryzen, Apple Silicon (M1/M2/M3);
  3. Место на диске: 1-2 Гб.
- Программные:
  1. ОС: Windows (10/новее), Mac (X/новее), Linux (любой дистрибутив);
  2. JDK: 21+.
### ▶️ Установка и запуск