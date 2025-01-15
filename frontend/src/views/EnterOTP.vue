

<template>
  <div class="flex justify-center items-center min-h-screen bg-gray-50">
    <div class="w-full max-w-md bg-white rounded-lg shadow-md p-8">
      <h2 class="text-3xl font-semibold mb-6 text-center">
        Enter the 6-digit OTP
      </h2>

      <p class="text-center text-sm text-gray-500 mb-6">
        Please enter the OTP sent to your phone number.
      </p>

      <form @submit.prevent="handleSubmit" class="mt-6 space-y-4">
        <div class="flex justify-center items-center space-x-2">
          <Input
            v-for="(value, index) in otp"
            :key="index"
            v-model="otp[index]"
            id="otp-input"
            name="otp-input"
            type="text"
            placeholder=""
            class="otp-input"
            maxlength="1"
            @input="focusNext(index)"
          />
        </div>

        <div class="mt-6">
          <Button type="submit" :disabled="loading">
            <span v-if="loading">Verifying...</span>
            <span v-else>Send</span>
          </Button>
        </div>
      </form>

      <div class="mt-4 text-center">
        <p class="text-sm text-gray-500">
          Didn't receive the code?
          <a
            href="#"
            class="text-indigo-600 hover:text-indigo-800 font-semibold"
            @click.prevent="resendOTP"
            >Resend OTP</a
          >
        </p>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent, ref, onMounted } from 'vue';
import { useRouter } from 'vue-router';
import Input from '../components/ui/Input.vue';
import Button from '../components/ui/Button.vue';

export default defineComponent({
  name: 'EnterOTP',
  components: {
    Input,
    Button,
  },
  setup() {
    const otp = ref(['', '', '', '', '', '']);
    const loading = ref(false);
    const router = useRouter();
    const phoneNumber = ref('');

    onMounted(() => {
      phoneNumber.value = localStorage.getItem('phoneNumber') || '';
    });

    const handleSubmit = async () => {
      const otpCode = otp.value.join('');
      if (otpCode.length < 6) {
        alert('Please enter a valid 6-digit OTP');
        return;
      }

      loading.value = true;

      try {
        const response = await fetch('http://localhost:8080/api/verification/verify', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify({
            phoneNumber: phoneNumber.value,
            code: otpCode,
          }),
        });

        const data = await response.json();

        if (response.ok && data.success) {
          router.push('/home'); // Redirect on successful verification
        } else {
          alert('Invalid OTP. Please try again.');
        }
      } catch (error) {
        console.error('Error during OTP verification:', error);
        alert('There was an error verifying the OTP. Please try again later.');
      } finally {
        loading.value = false;
      }
    };

    const focusNext = (index: number) => {
      if (otp.value[index].length === 1 && index < 5) {
        document.getElementsByName('otp-input')[index + 1].focus();
      }
    };

    const resendOTP = async () => {
      try {
        loading.value = true;
        const response = await fetch('http://localhost:8080/api/verification/', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify({
            phoneNumber: phoneNumber.value,
          }),
        });

        const data = await response.json();

        if (response.ok && data.success) {
          alert('OTP has been resent. Please check your phone.');
        } else {
          alert('Failed to resend OTP. Please try again.');
        }
      } catch (error) {
        console.error('Error during OTP resend:', error);
        alert('There was an error resending the OTP. Please try again later.');
      } finally {
        loading.value = false;
      }
    };

    return {
      otp,
      handleSubmit,
      focusNext,
      resendOTP,
      loading,
    };
  },
});
</script>

<style scoped>
.otp-input {
  text-align: center;
  font-size: 1.25rem;
  padding: 0.5rem;
  border: 1px solid #d1d5db;
  border-radius: 0.375rem;
  width: 3rem;
  height: 3rem;
  focus: ring-indigo-500;
  focus: border-indigo-500;
}
</style>

