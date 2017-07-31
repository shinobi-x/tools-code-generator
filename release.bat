rm -rf release/CodeGenerator/codegenerator-1.0.0.jar
rm -rf release/CodeGenerator/lib/*

call mvn clean package -Dmaven.test.skip=true 

cp -rf target/*.jar release/CodeGenerator/ 
cp -rf lib/* release/CodeGenerator/lib/