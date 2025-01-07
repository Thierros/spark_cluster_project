# Apache Spark cluster project
!['saprkingflow.drawio.png']()

---

**Project Overview: Apache Spark Cluster and Airflow Orchestration**  

This project involves setting up an **Apache Spark cluster** and using **Apache Airflow** as a data pipeline orchestration tool for task submission to the cluster. The project implements three types of tasks, each addressing the classic word count problem:  
- **Python Task**: Written in Python.  
- **Scala Task**: Written in Scala.  
- **Java Task**: Written in Java.  

The infrastructure consists of multiple **Docker containers**, including:  
- A **master node** and **worker nodes** for the Spark cluster.  
- **Airflow scheduler** and **Airflow web server** for managing and visualizing task workflows.  

### Key Features:  
- Demonstrates the integration of Apache Spark with Airflow for distributed data processing.  
- Showcases multi-language support with tasks written in Python, Scala, and Java.  
- Utilizes a containerized environment for simplicity and portability.  

This project offers a lightweight structure, making it easy to explore and replicate. You can try it out by diving into the codebase and adapting it to your own use cases.
