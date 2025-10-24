# CS-320-Software-Testing-Automation-QA

## Software Test Automation & QA: Project Portfolio

### Project One: Unit Test Files
- [Contact.java](./Contact.java)
- [ContactService.java](./ContactService.java)
- [ContactTest.java](./ContactTest.java)
- [ContactServiceTest.java](./ContactServiceTest.java)

### Project Two: Summary and Reflections Report
- [Summary and Reflections Report (PDF)](./7-2_Project_Two_Submission_Felie_Magbanua_101925_Final.pdf)

This repository contains my project submissions for CS-320: Software Test, Automation & QA. The artifacts include unit test files from Project One (Contact.java, ContactService.java, ContactTest.java, and ContactServiceTest.java) and a completed Summary and Reflections Report from Project Two. These projects focused on creating unit tests using code to uncover errors, analyzing various approaches to software testing based on requirements, and applying appropriate testing strategies to meet requirements throughout the software development life cycle. The work demonstrates my ability to perform requirements analysis, implement verification and validation practices, and apply quality management principles through systematic unit testing. This collection reflects the practical application of software engineering testing strategies that ensure code quality, functionality, and reliability.

My work on these projects began with understanding the requirements and translating them into testable, functional code. I ensured my code was functional and secure by relying on comprehensive unit testing that validated both what should work and what shouldn't. I created targeted tests that checked boundary conditions and edge cases at every stage. For example, when testing the Contact Service, I verified that IDs remained immutable, field lengths stayed within specified limits, and null values were properly rejected. This testing approach helped me catch issues early and maintain data integrity throughout development. Security was strengthened by validating all inputs against requirements and ensuring critical fields like IDs could not be modified after creation, preventing unauthorized changes. 

When it came to interpreting user needs, I carefully analyzed requirements specifications and translated each one into specific, testable criteria. For instance, when the Task Service required non-updatable IDs limited to 10 characters, I built tests to enforce that exact constraint. Every requirement received corresponding validation in my code, ensuring the final program directly addressed what users actually needed.

My approach to designing software started with thoroughly understanding the requirements before writing any code. I built each service with clear separation of concerns, designing components like Contact, Task, and Appointment to have their own classes with specific responsibilities and validation rules. I learned to design with testability in mind from the beginning, ensuring each component could be independently verified through unit tests. My design process included implementing immutable fields where specified, adding appropriate data validation, and creating methods that enforced business rules. By systematically testing at each development stage, I verified my design met all functional requirements before moving forward. This feedback cycle of testing and validation kept the project evolving with each improvement, helping me catch errors early and build more reliable software.
