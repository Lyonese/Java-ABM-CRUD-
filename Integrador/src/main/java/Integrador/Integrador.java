package Integrador;

import Clases.Asignatura;
import Clases.CargoDocente;
import Clases.Docente;
import Clases.Instituto;
import java.time.LocalDate;
import java.util.Scanner;

public class Integrador {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        boolean terminarPrograma = false;
        
        while (terminarPrograma == false) {
            try {
                System.out.println("=== MENU PRINCIPAL ===");
                System.out.println("1. Alta");
                System.out.println("2. Baja");
                System.out.println("3. Modificacion");
                System.out.println("4. Salir");
                System.out.print("Seleccione una accion: ");
                int accionSeleccionada = input.nextInt();
                input.nextLine();
                
                if (accionSeleccionada == 4) {
                    System.out.println("Saliendo del programa");
                    terminarPrograma = true;
                    continue;
                } else if (accionSeleccionada < 1 || accionSeleccionada > 3) {
                    System.out.println("Opcion invalida");
                    continue;
                }
                System.out.println("\n=== MENU CLASE ===");
                System.out.println("1. Instituto");
                System.out.println("2. Asignatura");
                System.out.println("3. Docente");
                System.out.println("4. Cargo Docente");
                System.out.print("Seleccione una clase: ");
                int entidadSeleccionada = input.nextInt();
                input.nextLine();
                
                switch (entidadSeleccionada) {
                    case 1 -> ejecutarAccion("Instituto", accionSeleccionada, input);
                    case 2 -> ejecutarAccion("Asignatura", accionSeleccionada, input);
                    case 3 -> ejecutarAccion("Docente", accionSeleccionada, input);
                    case 4 -> ejecutarAccion("Cargo Docente", accionSeleccionada, input);
                    default -> System.out.println("Opcion invalida");
                }
            } catch (Exception e) {
                System.out.println("Entrada invalida");
                input.nextLine();
            }
        }
    }

    private static void ejecutarAccion(String entidadSeleccionada, int accionSeleccionada, Scanner input) {
        
        switch (accionSeleccionada) {
            case 1 -> alta(entidadSeleccionada, input);
            case 2 -> baja(entidadSeleccionada, input);
            case 3 -> modificacion(entidadSeleccionada, input);
        }
    }

    private static void alta(String entidadSeleccionada, Scanner input) {
        
        System.out.println("=== ALTA DE " + entidadSeleccionada.toUpperCase() + " ===");
        Controladora gestorDatos = new Controladora();
        try {
            switch (entidadSeleccionada) {
                case "Instituto" -> {
                    System.out.print("Ingrese el codigo del instituto: ");
                    int codigo = input.nextInt();
                    input.nextLine();
                    System.out.print("Ingrese la denominacion del instituto: ");
                    String denominacion = input.nextLine();
                    Instituto nuevoInstituto = new Instituto(codigo, denominacion);
                    Instituto institutoEncontrado = gestorDatos.buscarInstituto(codigo);
                    
                    if (institutoEncontrado == null) {
                        gestorDatos.crearInstituto(nuevoInstituto);
                    } else {
                        System.out.println("El instituto con codigo " + codigo + " ya existe");
                    }
                }
                case "Asignatura" -> { 
                    System.out.print("Ingrese el codigo de la asignatura: ");
                    int codigo = input.nextInt();
                    input.nextLine();
                    System.out.print("Ingrese el nombre de la asignatura: ");
                    String nombre = input.nextLine();
                    System.out.print("Ingrese la descripcion de la asignatura: ");
                    String descripcion = input.nextLine();
                    System.out.print("Ingrese el codigo del instituto asociado: ");
                    int codigoInstituto = input.nextInt();
                    input.nextLine();
                    Instituto institutoResponsable = gestorDatos.buscarInstituto(codigoInstituto);
                    
                    if (institutoResponsable == null) {
                        System.out.println("El instituto con codigo " + codigoInstituto + " no existe");
                    } else {
                        System.out.print("Ingrese el numero de legajo del docente responsable: ");
                        int legajoDocente = input.nextInt();
                        input.nextLine();
                        Docente docenteResponsable = gestorDatos.buscarDocente(legajoDocente);
                        
                        if (docenteResponsable == null) {
                            System.out.println("El docente con legajo " + legajoDocente + " no existe");
                        } else {
                            Asignatura nuevaAsignatura = new Asignatura(codigo, nombre, descripcion, institutoResponsable, docenteResponsable);
                            Asignatura asignaturaEncontrada = gestorDatos.buscarAsignatura(codigo);
                            
                            if (asignaturaEncontrada == null) {
                                gestorDatos.crearAsignatura(nuevaAsignatura);
                                System.out.println("Asignatura creada exitosamente");
                            } else {
                                System.out.println("La asignatura con codigo " + codigo + " ya existe");
                            }
                        }
                    }
                }
                case "Docente" -> {
                    System.out.print("Ingrese el numero de legajo del docente: ");
                    int nroLegajo = input.nextInt();
                    input.nextLine();
                    System.out.print("Ingrese el nombre del docente: ");
                    String nombre = input.nextLine();
                    System.out.print("Ingrese el apellido del docente: ");
                    String apellido = input.nextLine();
                    System.out.print("Ingrese el DNI del docente: ");
                    int dni = input.nextInt();
                    input.nextLine();
                    System.out.print("Ingrese la fecha de nacimiento del docente (aaaa-mm-dd): ");
                    LocalDate fechaNacimiento = LocalDate.parse(input.nextLine());
                    System.out.print("Ingrese el contacto del docente: ");
                    String contacto = input.nextLine();
                    Docente nuevoDocente = new Docente(nroLegajo, nombre, apellido, dni, fechaNacimiento, contacto);
                    Docente docenteEncontrado = gestorDatos.buscarDocente(nroLegajo);
                    
                    if (docenteEncontrado == null) {
                        gestorDatos.crearDocente(nuevoDocente);
                        System.out.println("Docente creado con exito");
                    } else {
                        System.out.println("El docente con numero de legajo " + nroLegajo + " ya existe");
                    }
                }
                case "Cargo Docente" -> {
                    System.out.print("Ingrese el numero de cargo docente: ");
                    int nroCargo = input.nextInt();
                    input.nextLine();
                    System.out.print("Ingrese la dedicacion en horas del cargo docente: ");
                    int dedicacionHoras = input.nextInt();
                    input.nextLine();
                    System.out.print("Ingrese el numero de legajo del docente: ");
                    int legajoDocente = input.nextInt();
                    input.nextLine();
                    Docente docenteAsociado = gestorDatos.buscarDocente(legajoDocente);
                    
                    if (docenteAsociado == null) {
                        System.out.println("El docente con numero de legajo " + legajoDocente + " no existe");
                    } else {
                        System.out.print("Ingrese el codigo del instituto: ");
                        int codigoInstituto = input.nextInt();
                        input.nextLine();
                        Instituto institutoAsociado = gestorDatos.buscarInstituto(codigoInstituto);
                        
                        if (institutoAsociado == null) {
                            System.out.println("El instituto con codigo " + codigoInstituto + " no existe");
                        } else {
                            CargoDocente cargoDocente = new CargoDocente(nroCargo, docenteAsociado, institutoAsociado, dedicacionHoras);
                            CargoDocente cargoDocenteEncontrado = gestorDatos.buscarCargoDocente(nroCargo);
                            
                            if (cargoDocenteEncontrado == null) {
                                gestorDatos.crearCargoDocente(cargoDocente);
                                System.out.println("Cargo docente creado con exito");
                            } else {
                                System.out.println("El cargo docente con numero " + nroCargo + " ya existe");
                            }
                        }
                    }
                }
                default -> System.out.println("Entidad no reconocida");
            }
        } catch (Exception e) {
            System.out.println("Error durante la operacion: " + e.getMessage());
            input.nextLine();
        }
    }

    private static void baja(String entidadSeleccionada, Scanner input) {
        
        System.out.println("=== BAJA DE " + entidadSeleccionada.toUpperCase() + " ===");
        Controladora gestorDatos = new Controladora();
        try {
            switch (entidadSeleccionada) {
                case "Instituto" -> {
                    System.out.print("Ingrese el codigo del instituto a eliminar: ");
                    int codigo = input.nextInt();
                    input.nextLine();
                    Instituto institutoExistente = gestorDatos.buscarInstituto(codigo);
                    
                    if (institutoExistente == null) {
                        System.out.println("El instituto con codigo " + codigo + " no existe");
                    } else {
                        gestorDatos.eliminarInstituto(institutoExistente);
                        System.out.println("Instituto eliminado exitosamente");
                    }
                }
                case "Asignatura" -> {
                    System.out.print("Ingrese el codigo de la asignatura a eliminar: ");
                    int codigo = input.nextInt();
                    input.nextLine();
                    Asignatura asignaturaExistente = gestorDatos.buscarAsignatura(codigo);
                    
                    if (asignaturaExistente == null) {
                        System.out.println("La asignatura con codigo " + codigo + " no existe");
                    } else {
                        gestorDatos.eliminarAsignatura(asignaturaExistente);
                        System.out.println("Asignatura eliminada exitosamente");
                    }
                }
                case "Docente" -> {
                    System.out.print("Ingrese el numero de legajo del docente a eliminar: ");
                    int nroLegajo = input.nextInt();
                    input.nextLine();
                    Docente docenteExistente = gestorDatos.buscarDocente(nroLegajo);
                    
                    if (docenteExistente == null) {
                        System.out.println("El docente con numero de legajo " + nroLegajo + " no existe");
                    } else {
                        gestorDatos.eliminarDocente(docenteExistente);
                        System.out.println("Docente eliminado exitosamente");
                    }
                }
                case "Cargo Docente" -> {
                    System.out.print("Ingrese el numero de cargo docente a eliminar: ");
                    int nroCargo = input.nextInt();
                    input.nextLine();
                    CargoDocente cargoDocenteExistente = gestorDatos.buscarCargoDocente(nroCargo);
                    
                    if (cargoDocenteExistente == null) {
                        System.out.println("El cargo docente con numero " + nroCargo + " no existe");
                    } else {
                        gestorDatos.eliminarCargoDocente(cargoDocenteExistente);
                        System.out.println("Cargo docente eliminado exitosamente");
                    }
                }
                default -> System.out.println("Clase no valida");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Entrada invalida");
            input.nextLine();
        } catch (Exception e) {
            System.out.println("Ocurrio un error inesperado: " + e.getMessage());
        }
    }

    private static void modificacion(String entidadSeleccionada, Scanner input) { 
        
        Controladora gestorDatos = new Controladora();
        System.out.println("=== MODIFICACION DE " + entidadSeleccionada.toUpperCase() + " ===");
        try {
            switch (entidadSeleccionada) {
                case "Instituto" -> {
                    System.out.print("Ingrese el codigo del instituto a modificar: ");
                    int codigo = input.nextInt();
                    input.nextLine();
                    Instituto institutoExistente = gestorDatos.buscarInstituto(codigo);
                    
                    if (institutoExistente == null) {
                        System.out.println("El instituto con codigo " + codigo + " no existe");
                    } else {
                        System.out.print("Ingrese la nueva denominacion del instituto: ");
                        String nuevaDenominacion = input.nextLine();
                        institutoExistente.setInstituto_denominacion(nuevaDenominacion);
                        gestorDatos.modificarInstituto(institutoExistente);
                        System.out.println("Instituto modificado exitosamente");
                    }
                }
                case "Asignatura" -> {
                    System.out.print("Ingrese el codigo de la asignatura a modificar: ");
                    int codigoAsignatura = input.nextInt();
                    input.nextLine();
                    Asignatura asignaturaExistente = gestorDatos.buscarAsignatura(codigoAsignatura);
                    
                    if (asignaturaExistente == null) {
                        System.out.println("La asignatura con codigo " + codigoAsignatura + " no existe");
                    } else {
                        System.out.println("Seleccione el atributo a modificar:");
                        System.out.println("1. Nombre");
                        System.out.println("2. Descripcion");
                        System.out.print("Opcion: ");
                        int opcionAsignatura = input.nextInt();
                        input.nextLine();
                        switch (opcionAsignatura) {
                            case 1 -> {
                                System.out.print("Ingrese el nuevo nombre: ");
                                String nuevoNombre = input.nextLine();
                                asignaturaExistente.setAsignatura_nombre(nuevoNombre);
                            }
                            case 2 -> {
                                System.out.print("Ingrese la nueva descripcion: ");
                                String nuevaDescripcion = input.nextLine();
                                asignaturaExistente.setAsignatura_descripcion(nuevaDescripcion);
                            }
                            default -> {
                                System.out.println("Opcion invalida");
                                return;
                            }
                        }
                        gestorDatos.modificarAsignatura(asignaturaExistente);
                        System.out.println("Asignatura modificada exitosamente");
                    }
                }
                case "Docente" -> {
                    System.out.print("Ingrese el numero de legajo del docente a modificar: ");
                    int legajoDocente = input.nextInt();
                    input.nextLine();
                    Docente docenteExistente = gestorDatos.buscarDocente(legajoDocente);
                    
                    if (docenteExistente == null) {
                        System.out.println("El docente con legajo " + legajoDocente + " no existe");
                    } else {
                        System.out.println("Seleccione el atributo a modificar:");
                        System.out.println("1. Nombre");
                        System.out.println("2. Apellido");
                        System.out.println("3. DNI");
                        System.out.println("4. Fecha de nacimiento");
                        System.out.println("5. Contacto");
                        System.out.print("Opcion: ");
                        int opcionDocente = input.nextInt();
                        input.nextLine();
                        switch (opcionDocente) {
                            case 1 -> {
                                System.out.print("Ingrese el nuevo nombre: ");
                                String nuevoNombre = input.nextLine();
                                docenteExistente.setDocente_nombre(nuevoNombre);
                            }
                            case 2 -> {
                                System.out.print("Ingrese el nuevo apellido: ");
                                String nuevoApellido = input.nextLine();
                                docenteExistente.setDocente_apellido(nuevoApellido);
                            }
                            case 3 -> {
                                System.out.print("Ingrese el nuevo Dni: ");
                                int nuevoDni = input.nextInt();
                                input.nextLine();
                                docenteExistente.setDocente_dni(nuevoDni);
                            }
                            case 4 -> {
                                System.out.print("Ingrese la nueva fecha de nacimiento (AAAA-MM-DD): ");
                                LocalDate nuevaFechaNacimiento = LocalDate.parse(input.nextLine());
                                docenteExistente.setDocente_fecha_nacimiento(nuevaFechaNacimiento);
                            }
                            case 5 -> {
                                System.out.print("Ingrese el nuevo contacto: ");
                                String nuevoContacto = input.nextLine();
                                docenteExistente.setDocente_contacto(nuevoContacto);
                            }
                            default -> {
                                System.out.println("Opcion invalida");
                                return;
                            }
                        }
                        gestorDatos.modificarDocente(docenteExistente);
                        System.out.println("Docente modificado exitosamente");
                    }
                }
                case "Cargo Docente" -> {
                    System.out.print("Ingrese el numero de cargo docente a modificar: ");
                    int numeroCargo = input.nextInt();
                    input.nextLine();
                    CargoDocente cargoDocenteExistente = gestorDatos.buscarCargoDocente(numeroCargo);
                    
                    if (cargoDocenteExistente == null) {
                        System.out.println("El cargo docente con numero " + numeroCargo + " no existe");
                    } else {
                        System.out.print("Ingrese la nueva dedicación en horas: ");
                        int nuevaDedicacion = input.nextInt();
                        input.nextLine();
                        cargoDocenteExistente.setCargo_docente_dedicacion_horas(nuevaDedicacion);
                        gestorDatos.modificarCargoDocente(cargoDocenteExistente);
                        System.out.println("Cargo docente modificado exitosamente");
                    }
                }
                default -> System.out.println("Clase invalida");
            }
        } catch (Exception e) {
            System.out.println("Error durante la operacion: " + e.getMessage());
        }
    }
}