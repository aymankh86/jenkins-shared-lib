def python_version() {
    sh 'echo "Python version: 3.10"'
}

def lint() {
    echo "Linting..."
    sh 'rm -f flake8.out pylint.out'
    sh '${BUILD_VENV}/flake8 --exit-zero --doctests --output-file ./flake8.out'
    sh '${AIRFLOW_BUILD_VENV}/pylint dags --exit-zero -f parseable > ./pylint.out'
    sh '${BUILD_VENV}/pylint scripts --exit-zero -f parseable >> ./pylint.out'
    sh '${BUILD_VENV}/pylint rocks_extension --exit-zero -f parseable >> ./pylint.out'
}