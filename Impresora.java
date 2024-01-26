package Act3;

public class Impresora {
    private int nivelToner;
    private int numPaginasImpresas;
    private boolean impresionDobleCara;

    public int getNivelToner() {
        return nivelToner;
    }

    public void setNivelToner(int nivelToner) {
        this.nivelToner = nivelToner;
    }

    public int NumPaginasImpresas() {

        return numPaginasImpresas;
    }
    public int getNumPaginasImpresas() {

        return this.numPaginasImpresas;
    }

    public void setNumPaginasImpresas(int numPaginasImpresas) {

        this.numPaginasImpresas = numPaginasImpresas;
    }

    public boolean isImpresionDobleCara() {
        return impresionDobleCara;
    }

    public void setImpresionDobleCara(boolean impresionDobleCara) {

        this.impresionDobleCara = impresionDobleCara;
    }

//constructor
    public Impresora(int nivelToner, int numPaginasImpresas, boolean impresionDobleCara) {

        //verificamos nivel de toner inicial rango (0-100)

        if (nivelToner>=0 && nivelToner<=100){
            this.nivelToner = nivelToner;

        } else {
            this.nivelToner=0;
        }
        this.numPaginasImpresas = numPaginasImpresas;
        this.impresionDobleCara = impresionDobleCara;
    }

//Método agregar toner
    public int agregarToner(int cantidad){
        // Verificamos que la cantidad esté en el rango correcto (0-100)
        if (cantidad<=100 && cantidad>=0){
            // Verificamos que al agregar la cantidad de tóner no se supere el nivel máximo
            if (this.nivelToner + cantidad<=100){
                this.nivelToner+=cantidad;
                return  this.nivelToner;
            }
        }
        return -1;
    }

    //Método impresion paginas
    public int imprimirPaginas(int paginas){
        // Calculamos las páginas a imprimir teniendo en cuenta si es impresión a doble cara
        int paginasImprimir;
        int paginasImparDobleCara;
        if (this.impresionDobleCara){
            paginasImprimir= paginas/2;
            paginasImparDobleCara= paginas%2;
            paginasImprimir= paginasImprimir+paginasImparDobleCara;

        } else {
            paginasImprimir= paginas;

        }


        /* Otra opcion al bucle if
        int pagImpresas = this.impresionDobleCara ? paginas /2 : paginas;
        */

        //actualizamos numero de paginas
        this.numPaginasImpresas= this.numPaginasImpresas + paginasImprimir;

        return  paginasImprimir;

    }




}










