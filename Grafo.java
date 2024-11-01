import java.util.ArrayList;
import java.util.List;

public class Grafo {

    List <Vertice> vertices = new ArrayList<>();

    void addVertice(char identificador) {
        vertices.add(new Vertice(identificador, new ArrayList<>()));
    }

    void addArista(Vertice source, Vertice target){
        vertices.get(vertices.indexOf(source)).aristas.add(new Arista(source,target));
        vertices.get(vertices.indexOf(target)).aristas.add(new Arista(target,source));
    }

    void printLista() {
        System.out.println("Lista de adyacencia:");
        for (Vertice vertice : vertices) {
            System.out.printf("Vertice %s: ", vertice.identificador);
            for (Arista arista : vertice.aristas) {
                System.out.print(arista.target.identificador+" ");
            }
            System.out.println();
        }
    }

    void printSecuenciaDeGrados() {
        System.out.println("Secuencia de grados:");
        for (Vertice vertice : vertices) {
            System.out.printf("Vertice %s: %s%n", vertice.identificador, vertice.aristas.size());
        }
    }

    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        grafo.addVertice('A');
        grafo.addVertice('B');
        grafo.addVertice('C');
        grafo.addVertice('D');
        grafo.addVertice('E');
        grafo.addVertice('F');
        grafo.addVertice('G');
        grafo.addVertice('H');
        grafo.addVertice('I');
        grafo.addArista(grafo.vertices.get(0), grafo.vertices.get(1));
        grafo.addArista(grafo.vertices.get(0), grafo.vertices.get(2));
        grafo.addArista(grafo.vertices.get(1), grafo.vertices.get(3));
        grafo.addArista(grafo.vertices.get(1), grafo.vertices.get(4));
        grafo.addArista(grafo.vertices.get(2), grafo.vertices.get(5));
        grafo.addArista(grafo.vertices.get(2), grafo.vertices.get(6));
        grafo.addArista(grafo.vertices.get(3), grafo.vertices.get(4));
        grafo.addArista(grafo.vertices.get(3), grafo.vertices.get(7));
        grafo.addArista(grafo.vertices.get(4), grafo.vertices.get(8));
        grafo.addArista(grafo.vertices.get(5), grafo.vertices.get(6));
        grafo.addArista(grafo.vertices.get(6), grafo.vertices.get(7));
        grafo.addArista(grafo.vertices.get(7), grafo.vertices.get(8));
        grafo.addArista(grafo.vertices.get(8), grafo.vertices.get(5));
        grafo.printLista();
        grafo.printSecuenciaDeGrados();
    }

    class Arista{
        Vertice source;
        Vertice target;
        public Arista(Vertice source,Vertice target) {
            this.source = source;
            this.target = target;
        }
    }

    class Vertice{
        char identificador;
        List<Arista> aristas;

        public Vertice(char identificador, List<Arista> aristas) {
            this.identificador = identificador;
            this.aristas = aristas;
        }
    }
}


