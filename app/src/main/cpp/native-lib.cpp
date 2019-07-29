#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring

JNICALL
Java_com_jni_MathUtils_stringFromJNI(
        JNIEnv *env,
        jobject /* this */, jstring str) {
    const char *hello = "Hello from C++";
//    return env->NewStringUTF(hello.c_str());
    return str;
//    return "Hello from C++";
}

extern "C"
JNIEXPORT jint
JNICALL
Java_com_jni_MathUtils_add(JNIEnv *env, jobject, jint x, jint y) {
    return x + y;

}