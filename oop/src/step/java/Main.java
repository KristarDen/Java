package step.java;

import step.java.library.Book;
import step.java.library.Hologram;
import step.java.library.Journal;
import step.java.library.Library;

public class Main {

    public static void main(String[] args) {
        Library lib = new Library() ;
        lib.add( new Journal( "Quantum Mechanics", "2021, 1" ) ) ;
        lib.add( new Book( "Martin Eden", "Jack London" ) ) ;
        lib.add( new Hologram( "Pectoral" ) ) ;
        lib.print() ;
    }
}
/*
    ООП - объектно-ориентированная парадигма программирования
    Суть: объекты + связи
    Предметная область --> объекты + связи
                   моделирование
    Модель - представление об исходной системе, ограниченное
             определенными критериями
    В терминах ООП моделирование = абстрагирование

    Инкапсуляция - "все мое ношу с собой"
    "+" самостоятельность объектов, возможность копирования/переноса
    "-" дублирование общих элементов в каждом объекте
      --> IoC/DI (Inversion of Control / Dependency Injection)

    Полиморфизм - (от поли- много, морф- форма) / обобщение
     - параметрический П - перегрузка методов
     - статический П - разные реализации одного интерфейса
     одна из главных задач - сложить в один массив разные объекты

    Наследование / расширение - механизм реализации полиморфизма
 */