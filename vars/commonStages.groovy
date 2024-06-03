def lint() {
    return {
        stage("Lint") {
            steps {
                echo "Linting..."
                sh 'rm -f flake8.out pylint.out'
                sh '${BUILD_VENV}/flake8 --exit-zero --doctests --output-file ./flake8.out'
                sh '${AIRFLOW_BUILD_VENV}/pylint dags --exit-zero -f parseable > ./pylint.out'
                sh '${BUILD_VENV}/pylint scripts --exit-zero -f parseable >> ./pylint.out'
                sh '${BUILD_VENV}/pylint rocks_extension --exit-zero -f parseable >> ./pylint.out'
            }
        }
    }
}