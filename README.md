# 클라우드 네이티브 인 액션

## 개발 목표

---
 - 클라우드 환경에서 복원력 있고 탄력적인 애플리케이션을 만들기 위한 학습을 목표로한 프로젝트
 - 책이라는 하나의 섹션을 두고 지속적으로 궁금증을 묻는다.



### 설정

--- 

#### 도커

패키토 빌드팩의 경우 별도 툴이나 의존성 라이브러리 추가없이 스프링 부트 애플리케이션을 컨테이너화 가능.

- 프로젝트 네이밍 규칙을 준수해야한다.
- 도커 데스트톱이 실행 되어 있어야한다.

위와 같은 조건을 통해 빌드하게 될 경우 cloud-native:0.0.1-SNAPSHOT와 같은 네이밍을 갖은 이미지를 생성할수 있다.
```sh
./gradlew bootBuildImage
```

다음명령어를 통해 실행이 가능하다.
```
// 도커 이미지 세부정부 SELECT
docker image cloud-native:0.0.1-SNAPSHOT

// 도커 이미지 실행
docker run --rm --name cloud-native -p 8000:8080 cloud-native:0.0.1-SNAPSHOT
```

#### 쿠버네티스 

쿠버네티스 다운로드
//power shell

// [초코가 없을 경우 다운]
```sh
Set-ExecutionPolicy Bypass -Scope Process -Force; `
[System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; `
iex ((New-Object System.Net.WebClient).DownloadString('https://community.chocolatey.org/install.ps1'))
```

// 쿠버네티스 다운로드
```sh
choco install minikube
```

```sh
./gradlew bootBuildImage
```

루트 폴더 로 이동하여 작업
```sh
 docker images cloud-native:0.0.1-SNAPSHOT
```

쿠버네티스 실행
```sh
minikube start
```

이전에 로드한 도커 내에 있는 이미지를 쿠버네티스 이미지 로드
```sh
minikube image load cloud-native:0.0.1-SNAPSHOT   
```

쿠버네티스 이미지 생성 
```sh
kubectl create deployment cloude-native --image=cloud-native:0.0.1-SNAPSHOT   
```

쿠버네티스 외부로 노출 되도록 설정 
```sh
kubectl expose deployment cloud-native --name=cloud-native --port=8000
```

외부로 노출된 서비스 포트포워딩
```sh
kubectl port-forward service/cloud-native 8001:8000
```
