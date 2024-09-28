def build(){
    sh: "docker build -f ${rutaArchivoDocker} -t ${nombreImagenDocker} ${carpetaDocker}"
}

def push(){
    sh: "docker push ${nombreImagenDocker}"
}
