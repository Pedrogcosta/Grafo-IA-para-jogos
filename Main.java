import java.util.*;

class Grafo 
{
    private int numNos;
    private ArrayList<Integer>[] matrizAdj;

    Grafo(int n) 
    {
        numNos = n;
        matrizAdj = new ArrayList[n];
        for (int i=0; i<n; ++i)
            matrizAdj[i] = new ArrayList();
    }

    void adicionarAresta(int n, int temp) 
    {
        matrizAdj[n].add(temp);
    }

    void visite(int n, boolean[] visitado, Stack<Integer> o) 
    {
        visitado[n] = true;
        Integer p;

        Iterator<Integer> i = matrizAdj[n].iterator();
        while (i.hasNext()) 
        {
            p = i.next();
            if (!visitado[p])
            {  
                visite(p, visitado, o);
            }
        }

        o.push(n);
    }

    List<Integer> ordenacaoTopologica() 
    {
        Stack<Integer> o = new Stack<>();
        boolean[] visitado = new boolean[numNos];

        for (int i = 0; i < numNos; i++) 
        {
            if (!visitado[i])
                visite(i, visitado, o);
        }

        List<Integer> resultado = new ArrayList<>();
        while (!o.empty()) 
        {
            resultado.add(o.pop());
        }

        return resultado;
    }
}

public class Main 
{
    public static void main(String args[]) 
    {
        Grafo g = new Grafo(6);
        g.adicionarAresta(5, 2);
        g.adicionarAresta(5, 0);
        g.adicionarAresta(4, 0);
        g.adicionarAresta(4, 1);
        g.adicionarAresta(2, 3);
        g.adicionarAresta(3, 1);

        System.out.println("Ordenação:");
        System.out.println("----------");
        List<Integer> resultado = g.ordenacaoTopologica();
        for (Integer vertice : resultado)
            System.out.print(vertice + " ");
    }
}
