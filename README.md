# Exam

This repository has been created to assess students' skills on Spring.

## First build

After cloning this repository, run this command:

```
   mvn clean spring-boot:run
```

to retrieve the dependencies, compile and run the program for the first time.

```
  [...]
  2024-04-09T21:27:27.338+02:00  INFO 21340 --- [payroll] [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
  2024-04-09T21:27:27.517+02:00  WARN 21340 --- [payroll] [           main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be per
  formed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
  2024-04-09T21:27:27.752+02:00  INFO 21340 --- [payroll] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path ''
  2024-04-09T21:27:27.760+02:00  INFO 21340 --- [payroll] [           main] ch.etmles.payroll.PayrollApplication     : Started PayrollApplication in 2.972 seconds (process running for 3.247)
  2024-04-09T21:27:27.802+02:00  INFO 21340 --- [payroll] [           main] c.e.payroll.Repositories.LoadDatabase    : Preloading Employee{id=1, name='Bilbo Baggins', role='burglar'}
  2024-04-09T21:27:27.803+02:00  INFO 21340 --- [payroll] [           main] c.e.payroll.Repositories.LoadDatabase    : Preloading Employee{id=2, name='Frodo Baggins', role='thief'}
  [...]
```

## Test using http requests

Got the file [project]\src\main\java\ch\etmles\payroll\Controllers\EmployeeController.java

Before all routes methods, you will find a curl sample.

## Backlog

Read the different issues.

[Issues](https://github.com/ETML-ES-FWBE/exam/issues)

