package com.company;
import ucn.*;
import ucn.StdOut;
import ucn.StdIn;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        ArchivoEntrada arch1 = new ArchivoEntrada("DatosClientes.txt");
        ArchivoSalida arch2 = new ArchivoSalida("Estadisticas.txt");

        String menu = "[A]:Generar venta \n[B]:Mostrar ventas \n[C]:Estadisticas \n[D]:Salir";
        String GenerarVenta = "A";
        String MostrarVentas = "B";
        String Estadisticas = "C";
        String Salir = "D";
        String tipoPC = "";
        String Nombre = "";
        String Apellido = "";
        String Respuesta = "";
        int PrecioBasico = 450000;
        int PrecioIntermedio = 650000;
        int PrecioAlto = 900000;
        String monitor = "no";
        String agregados = "no";
        int contClientes = 0;
        int contPresuBasico = 0;
        int contPresuMedio = 0;
        int contPresuAlto = 0;
        int contPCbasico = 0;
        int contPCIntermedio = 0;
        int contPCalto = 0;
        String compradorMay = "";
        String apellidoMay = "";
        int boletaMay = 0;
        String compradorSIagreg = "";
        int acumPcBasico = 0;
        int acumPcInter = 0;
        int acumcAlto = 0;
        int clientesSINagregados = 0;
        String presupuesto = "";
        int MontoEstadisticas = 0;


        StdOut.println("Seleccione una opcion \n" + menu);
        String opcionElegida = StdIn.readString();
        while (!((opcionElegida.equalsIgnoreCase("A")) || (opcionElegida.equalsIgnoreCase("B")) || (opcionElegida.equalsIgnoreCase("C")) || (opcionElegida.equalsIgnoreCase("D")))) {
            StdOut.println("La opcion solo puede ser: A,B,C o D\n" + menu);
            opcionElegida = StdIn.readString();
        }
        while (!opcionElegida.equalsIgnoreCase(Salir)) {

            if (opcionElegida.equalsIgnoreCase("a")) {
                do {
                    StdOut.println("Escriba el Nombre del cliente");
                    Nombre = StdIn.readString();
                    StdOut.println("Escriba el Apellido del cliente");
                    Apellido = StdIn.readString();
                    StdOut.println("Cual es su presupuesto? (Bajo, Medio o Alto)");

                    presupuesto = StdIn.readString();
                    while (!((presupuesto.equalsIgnoreCase("bajo")) || (presupuesto.equalsIgnoreCase("medio")) || (presupuesto.equalsIgnoreCase("alto")))) {
                        StdOut.println("No corresponde a una de las opciones de presupuesto\n" + "Cual es su presupuesto? (Bajo, Medio o Alto)");
                        presupuesto = StdIn.readString();
                    }
                    int MontoTotal = 0;

                    if (presupuesto.equalsIgnoreCase("bajo")) {
                        tipoPC = "Basico";
                        MontoTotal += 450000;
                        StdOut.println(MontoTotal);
                        monitor = "no";
                        contPresuBasico++;
                        acumPcBasico += 450000;
                        contPCbasico++;
                        if (MontoTotal > boletaMay) {
                            boletaMay = MontoTotal;
                            compradorMay = Nombre;
                            apellidoMay = Apellido;
                        }

                    } else if (presupuesto.equalsIgnoreCase("medio")) {


                        contPresuMedio++;
                        StdOut.println("Elija una opcion de PC (Intermedio o Basico)");
                        tipoPC = StdIn.readString();
                        while (!(tipoPC.equalsIgnoreCase("Intermedio") || tipoPC.equalsIgnoreCase("Basico"))) {
                            StdOut.println("esa opcion no es correcta, selecciona otra (Intermedio o Basico)");
                            tipoPC = StdIn.readString();
                        }
                        if (tipoPC.equalsIgnoreCase("intermedio")) {
                            contPCIntermedio++;
                            MontoTotal += 650000;
                            acumPcInter += 650000;

                            StdOut.println("Desea ver los agregados?");
                            String respuestaAgre = StdIn.readString();

                            while (!((respuestaAgre.equalsIgnoreCase("si")) || (respuestaAgre.equalsIgnoreCase("no")))) {
                                StdOut.println("La respues solo puede ser SI o NO");
                                respuestaAgre = StdIn.readString();
                            }
                            if (respuestaAgre.equalsIgnoreCase("si")) {

                                StdOut.println("Desea llevar un monitor por $80.000 adicionales?");
                                String respuestaMon = StdIn.readString();
                                while (!((respuestaMon.equalsIgnoreCase("si")) || (respuestaMon.equalsIgnoreCase("no")))) {
                                    StdOut.println("La respues solo puede ser SI o NO");
                                    respuestaMon = StdIn.readString();
                                }

                                if (respuestaMon.equalsIgnoreCase("si")) {
                                    MontoTotal += 80000;
                                    acumPcInter += 80000;
                                    clientesSINagregados++;
                                    monitor = "si";
                                    agregados = "si";
                                    if (MontoTotal > boletaMay) {
                                        boletaMay = MontoTotal;
                                        compradorMay = Nombre;
                                        apellidoMay = Apellido;
                                    }
                                }

                                StdOut.println("Desea llevar un mouse por $20.000 adicionales?");
                                String respuestaMous = StdIn.readString();
                                while (!((respuestaMous.equalsIgnoreCase("si")) || (respuestaMous.equalsIgnoreCase("no")))) {
                                    StdOut.println("La respues solo puede ser SI o NO");
                                    respuestaMous = StdIn.readString();
                                }
                                if (respuestaMous.equalsIgnoreCase("si")) {
                                    MontoTotal += 20000;
                                    acumPcInter += 20000;
                                    agregados = "si";
                                    clientesSINagregados++;
                                    if (MontoTotal > boletaMay) {
                                        boletaMay = MontoTotal;
                                        compradorMay = Nombre;
                                        apellidoMay = Apellido;
                                    }
                                }
                            }
                        } else if (tipoPC.equalsIgnoreCase("basico")) {
                            contPCbasico++;
                            MontoTotal += 450000;
                            acumPcBasico++;

                            StdOut.println("Desea ver los agregados?");
                            String respuestaAgre = StdIn.readString();
                            while (!((respuestaAgre.equalsIgnoreCase("si")) || (respuestaAgre.equalsIgnoreCase("no")))) {
                                StdOut.println("La respues solo puede ser SI o NO");
                                respuestaAgre = StdIn.readString();
                            }
                            if (respuestaAgre.equalsIgnoreCase("si")) {

                                StdOut.println("Desea llevar un monitor por $80.000 adicionales?");
                                String respuestaMon = StdIn.readString();
                                while (!((respuestaMon.equalsIgnoreCase("si")) || (respuestaMon.equalsIgnoreCase("no")))) {
                                    StdOut.println("La respues solo puede ser SI o NO");
                                    respuestaMon = StdIn.readString();
                                }

                                if (respuestaMon.equalsIgnoreCase("si")) {
                                    MontoTotal += 80000;
                                    acumPcInter += 80000;
                                    clientesSINagregados++;
                                    monitor = "si";
                                    agregados = "si";
                                    if (MontoTotal > boletaMay) {
                                        boletaMay = MontoTotal;
                                        compradorMay = Nombre;
                                        apellidoMay = Apellido;
                                    }
                                }

                                StdOut.println("Desea llevar un combo de perifericos (Teclado, Mouse y Mousepad) por $70.000?");
                                String respuestaPer = StdIn.readString();
                                while (!((respuestaPer.equalsIgnoreCase("si")) || (respuestaPer.equalsIgnoreCase("no")))) {
                                    StdOut.println("La respuesta solo puede ser SI o NO");
                                    respuestaPer = StdIn.readString();

                                }
                                if (respuestaPer.equalsIgnoreCase("si")) {
                                    MontoTotal += 70000;
                                    acumPcBasico += 70000;
                                    agregados = "si";
                                    clientesSINagregados++;
                                    if (MontoTotal > boletaMay) {
                                        boletaMay = MontoTotal;
                                        compradorMay = Nombre;
                                        apellidoMay = Apellido;

                                    }
                                }
                            }
                        }
                    } else if (presupuesto.equalsIgnoreCase("alto")) {
                        contPresuAlto++;
                        StdOut.println("Elija una opcion de PC (Intermedio, Basico o alto)");
                        tipoPC = StdIn.readString();
                        while (!(tipoPC.equalsIgnoreCase("Intermedio") || tipoPC.equalsIgnoreCase("Basico") || tipoPC.equalsIgnoreCase("alto"))) {
                            StdOut.println("esa opcion no es correcta, selecciona otra (Intermedio, Basico o Alto)");
                            tipoPC = StdIn.readString();
                        }
                        if (tipoPC.equalsIgnoreCase("basico")) {
                            MontoTotal += 450000;
                            contPCbasico++;
                            if (MontoTotal > boletaMay) {
                                boletaMay = MontoTotal;
                                compradorMay = Nombre;
                                apellidoMay = Apellido;
                            }
                        } else if (tipoPC.equalsIgnoreCase("intermedio")) {
                            MontoTotal += 650000;
                            contPCIntermedio++;
                            if (MontoTotal > boletaMay) {
                                boletaMay = MontoTotal;
                                compradorMay = Nombre;
                                apellidoMay = Apellido;
                            }
                        }
                        if (tipoPC.equalsIgnoreCase("Intermedio") || tipoPC.equalsIgnoreCase("Basico")) {

                            StdOut.println("Desea ver los agregados?");
                            String respuestaAgreg = StdIn.readString();
                            while (!((respuestaAgreg.equalsIgnoreCase("si")) || (respuestaAgreg.equalsIgnoreCase("no")))) {
                                StdOut.println("La respuesta solo puede ser SI o NO");
                                respuestaAgreg = StdIn.readString();
                            }
                            if (respuestaAgreg.equalsIgnoreCase("si")) {

                                StdOut.println("Desea llevar un monitor por $80.000 adicionales?");
                                String respuestaMon = StdIn.readString();
                                while (!((respuestaMon.equalsIgnoreCase("si")) || (respuestaMon.equalsIgnoreCase("no")))) {
                                    StdOut.println("La respues solo puede ser SI o NO");
                                    respuestaMon = StdIn.readString();
                                }

                                if (respuestaMon.equalsIgnoreCase("si")) {
                                    MontoTotal += 80000;
                                    acumPcInter += 80000;
                                    clientesSINagregados++;
                                    monitor = "si";
                                    agregados = "si";
                                    if (MontoTotal > boletaMay) {
                                        boletaMay = MontoTotal;
                                        compradorMay = Nombre;
                                        apellidoMay = Apellido;
                                    }
                                }

                                StdOut.println("Desea un aumento de memoria RAM y unos perifericos (teclado y mouse) por $120.000?");
                                String respuestaAgre = StdIn.readString();
                                while (!((respuestaAgre.equalsIgnoreCase("si")) || (respuestaAgre.equalsIgnoreCase("no")))) {
                                    StdOut.println("La respuesta solo puede ser SI o NO");
                                    respuestaAgre = StdIn.readString();
                                }
                                if (respuestaAgre.equalsIgnoreCase("si"))
                                    MontoTotal += 120000;
                                agregados = "si";

                                clientesSINagregados++;
                                if (MontoTotal > boletaMay) {
                                    boletaMay = MontoTotal;
                                    compradorMay = Nombre;
                                    apellidoMay = Apellido;


                                }
                            }
                        } else if (tipoPC.equalsIgnoreCase("alto")) {
                            MontoTotal += 900000;
                            contPCalto++;
                            if (MontoTotal > boletaMay) {
                                boletaMay = MontoTotal;
                                compradorMay = Nombre;
                                apellidoMay = Apellido;
                            }
                            StdOut.println("Desea ver los agregados?");
                            String respuestaAgreg = StdIn.readString();
                            while (!((respuestaAgreg.equalsIgnoreCase("si")) || (respuestaAgreg.equalsIgnoreCase("no")))) {
                                StdOut.println("La respuesta solo puede ser SI o NO");
                                respuestaAgreg = StdIn.readString();
                            }
                            if (respuestaAgreg.equalsIgnoreCase("si")) {

                                StdOut.println("Desea llevar un monitor por $80.000 adicionales?");
                                String respuestaMon = StdIn.readString();
                                while (!((respuestaMon.equalsIgnoreCase("si")) || (respuestaMon.equalsIgnoreCase("no")))) {
                                    StdOut.println("La respues solo puede ser SI o NO");
                                    respuestaMon = StdIn.readString();
                                }

                                if (respuestaMon.equalsIgnoreCase("si")) {
                                    MontoTotal += 80000;
                                    acumPcInter += 80000;
                                    clientesSINagregados++;
                                    monitor = "si";
                                    agregados = "si";
                                    if (MontoTotal > boletaMay) {
                                        boletaMay = MontoTotal;
                                        compradorMay = Nombre;
                                        apellidoMay = Apellido;
                                    }
                                }

                                StdOut.println("Desea llevar una refrigeracion liquida por $100.000?");
                                String respuestaRefri = StdIn.readString();
                                while (!((respuestaRefri.equalsIgnoreCase("si")) || (respuestaRefri.equalsIgnoreCase("no")))) {
                                    StdOut.println("La respuesta solo puede ser SI o NO");
                                    respuestaRefri = StdIn.readString();
                                }
                                if (respuestaRefri.equalsIgnoreCase("si")) {
                                    MontoTotal += 100000;
                                    clientesSINagregados++;
                                    agregados = "si";

                                    if (MontoTotal > boletaMay) {
                                        boletaMay = MontoTotal;
                                        compradorMay = Nombre;
                                        apellidoMay = Apellido;
                                    }
                                }
                            }
                        }
                    }

                    contClientes++;
                    StdOut.println("Comprobante de venta: " + Nombre + " " + Apellido + "," + "Presupuesto " + presupuesto + "," + " Pc " + tipoPC + "," + monitor + " lleva monitor" + "," + agregados + " lleva agregados" + ", monto a pagar: " + MontoTotal);


                    StdOut.println("Desea ingresar otro cliente");
                    Respuesta = StdIn.readString();
                    while (!((Respuesta.equalsIgnoreCase("si")) || (Respuesta.equalsIgnoreCase("no")))) {
                        StdOut.println("La respuesta solo puede ser SI o NO");
                        Respuesta = StdIn.readString();
                    }
                } while (Respuesta.equalsIgnoreCase("si"));
                StdOut.println("El cliente que con la boleta mas grande es: " + compradorMay + " " + apellidoMay + " con un monto total a pagar de :" + boletaMay);

            } else if (opcionElegida.equalsIgnoreCase("b")) {
                for (int i = 1; i <= 15; i++) {

                    while (!arch1.isEndFile()) {
                        Registro regEnt = arch1.getRegistro();
                        String NombreR = regEnt.getString();
                        String ApellidoR = regEnt.getString();
                        String presupuestoR = regEnt.getString();
                        String TipoPCR = regEnt.getString();
                        String monitoR = regEnt.getString();
                        String agregadosReg = regEnt.getString();
                        int MontoTotalR = 0;
                        if (presupuestoR.equalsIgnoreCase("presupuesto bajo")) {
                            contPresuBasico++;
                            MontoTotalR += 450000;
                            if (MontoTotalR > boletaMay) {
                                contPCbasico++;
                                boletaMay = MontoTotalR;
                                compradorMay = Nombre;
                                apellidoMay = Apellido;
                            }
                        } else if (presupuestoR.equalsIgnoreCase("presupuesto medio")) {
                            contPresuMedio++;
                            if (monitoR.equalsIgnoreCase("si"))
                                MontoTotalR += 80000;
                            if (MontoTotalR > boletaMay) {
                                boletaMay = MontoTotalR;
                                compradorMay = NombreR;
                                apellidoMay = ApellidoR;
                            }
                            if (TipoPCR.equalsIgnoreCase("PC intermedio")) {
                                MontoTotalR += 650000;
                                contPCIntermedio++;
                                if (MontoTotalR > boletaMay) {
                                    boletaMay = MontoTotalR;
                                    compradorMay = NombreR;
                                    apellidoMay = ApellidoR;
                                }
                                if (agregadosReg.equalsIgnoreCase("si")) {
                                    MontoTotalR += 20000;
                                    if (MontoTotalR > boletaMay) {
                                        boletaMay = MontoTotalR;
                                        compradorMay = NombreR;
                                        apellidoMay = ApellidoR;
                                    }
                                }
                            } else if (TipoPCR.equalsIgnoreCase("pc básico")) {
                                MontoTotalR += 450000;
                                contPCbasico++;
                                if (MontoTotalR > boletaMay) {
                                    boletaMay = MontoTotalR;
                                    compradorMay = NombreR;
                                    apellidoMay = ApellidoR;
                                }
                                if (agregadosReg.equalsIgnoreCase("si")) {
                                    MontoTotalR += 70000;
                                    if (MontoTotalR > boletaMay) {
                                        boletaMay = MontoTotalR;
                                        compradorMay = NombreR;
                                        apellidoMay = ApellidoR;
                                    }
                                }
                            }
                        } else if (presupuestoR.equalsIgnoreCase("presupuesto alto")) {
                            contPresuAlto++;
                            if (monitoR.equalsIgnoreCase("si"))
                                MontoTotalR += 80000;
                            if (MontoTotalR > boletaMay) {
                                boletaMay = MontoTotalR;
                                compradorMay = NombreR;
                                apellidoMay = ApellidoR;
                            }

                            if (TipoPCR.equalsIgnoreCase("pc alto")) {
                                MontoTotalR += 900000;
                                contPCalto++;
                                if (MontoTotalR > boletaMay) {
                                    boletaMay = MontoTotalR;
                                    compradorMay = NombreR;
                                    apellidoMay = ApellidoR;
                                }
                                if (agregadosReg.equalsIgnoreCase("si")) {
                                    MontoTotalR += 100000;
                                    if (MontoTotalR > boletaMay) {
                                        boletaMay = MontoTotalR;
                                        compradorMay = NombreR;
                                        apellidoMay = ApellidoR;
                                    }
                                }
                            } else if (TipoPCR.equalsIgnoreCase("pc intermedio")) {
                                MontoTotalR += 650000;
                                contPCIntermedio++;
                                if (MontoTotalR > boletaMay) {
                                    boletaMay = MontoTotalR;
                                    compradorMay = NombreR;
                                    apellidoMay = ApellidoR;
                                }
                                if (agregadosReg.equalsIgnoreCase("si")) {
                                    MontoTotalR += 120000;
                                    if (MontoTotalR > boletaMay) {
                                        boletaMay = MontoTotalR;
                                        compradorMay = NombreR;
                                        apellidoMay = ApellidoR;
                                    }
                                }
                            } else if (TipoPCR.equalsIgnoreCase("pc básico")) {
                                MontoTotalR += 450000;
                                contPCbasico++;
                                if (MontoTotalR > boletaMay) {
                                    boletaMay = MontoTotalR;
                                    compradorMay = NombreR;
                                    apellidoMay = ApellidoR;
                                }
                                if (agregadosReg.equalsIgnoreCase("si")) {
                                    MontoTotalR += 120000;
                                    if (MontoTotalR > boletaMay) {
                                        boletaMay = MontoTotalR;
                                        compradorMay = NombreR;
                                        apellidoMay = ApellidoR;
                                    }
                                }
                            }
                        }
                        contClientes++;
                        StdOut.println("Comprobante de venta: " + NombreR + " " + ApellidoR + "," + presupuestoR + "," + TipoPCR + "," + monitoR + " lleva monitor" + "," + agregadosReg + " lleva agregados" + ", monto a pagar: " + MontoTotalR);
                    }

                }
            }else if (opcionElegida.equalsIgnoreCase("c")) {

                //n1
                StdOut.println("la venta mas grande fue de un total de: "+boletaMay+" y corresponde a "+compradorMay+" "+apellidoMay);
                //n2
                StdOut.println("El promedio de clientes con presupuesto bajo es de : "  +((contPresuBasico*1.0)/contClientes));
            }


            StdOut.println("Seleccione una opcion \n" + menu);
            opcionElegida = StdIn.readString();
            while (!((opcionElegida.equalsIgnoreCase("A")) || (opcionElegida.equalsIgnoreCase("B")) || (opcionElegida.equalsIgnoreCase("C")) || (opcionElegida.equalsIgnoreCase("D")))) {
                StdOut.println("La opcion solo puede ser: A,B,C o D\n" + menu);
                opcionElegida = StdIn.readString();
            }
        }
        //opcion D escritura de Estadisticas.txt
        Registro registroSalida = new Registro(1);

        String primeraEstadistica = "la venta mas grande fue de un total de: "+boletaMay+" y corresponde a "+compradorMay+" "+apellidoMay;
        registroSalida.agregarCampo(primeraEstadistica);
        arch2.writeRegistro(registroSalida);

        String segundaEstadistica = ("El promedio de clientes con presupuesto bajo es de : "  +((contPresuBasico*1.0)/contClientes));
        registroSalida = new Registro(1);
        registroSalida.agregarCampo(segundaEstadistica);
        arch2.writeRegistro(registroSalida);

        String hola="Holaaaa";
        registroSalida=new Registro(1);
        registroSalida.agregarCampo(hola);
        arch2.writeRegistro(registroSalida);;

        StdOut.println("Muchas Gracias. Programa finalizado.");
        arch1.close();
        arch2.close();

    }
}
