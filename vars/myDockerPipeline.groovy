def call(Map params){
    pipeline{
        agent any
        
        stages{
            stage("Construyendo docker"){
                steps{
                    script{
                        myDockerLib.build(rutaArchivoDocker: "${params.rutaArchivoDocker}",
                                            nombreImagenDocker: "${params.nombreImagenDocker}",
                                            carpetaDocker: "${params.carpetaDocker}")
                        }
                }
                
            }

            stage("Pusheando docker"){
                steps{
                    script{
                        myDockerLib.push(nombreImagenDocker: "${params.nombreImagenDocker}")
                    }
                }
                
            }
        }
    }
}
