

<template>
  <div class="flex justify-center items-center min-h-screen md:bg-gray-50">
    <div class="w-full max-w-md bg-white rounded-lg md:shadow-lg p-8">
      <h1 class="text-3xl font-semibold text-center text-gray-800 mb-6">Verify Phone</h1>
      <p class="text-center text-sm text-gray-500 mb-6">
        Enter your phone number to receive a verification code.
      </p>
      <form @submit.prevent="sendVerification">
        <label for="phoneNumber" class="block text-sm font-medium text-gray-700">Phone Number:</label>
         <div class="mb-4 flex items-center space-x-2">
          <!-- Dropdown Select for Country Flags and Country Codes -->
          <select v-model="countryCode" id="countryCode" class="w-1/4 px-2 py-2 border border-gray-300 rounded-lg focus:ring-indigo-500 focus:border-indigo-500">
            <option value="+62">🇮🇩 +62</option>
            <option value="+1">🇺🇸 +1</option>
            <option value="+44">🇬🇧 +44</option>
            <!-- Add more flags and corresponding country codes as needed -->
          </select>

          <!-- Phone Number Input -->
          <input
            type="tel"
            v-model="phoneNumber"
            id="phoneNumber"
            class="w-3/4 px-3 py-2 border border-gray-300 rounded-lg focus:ring-indigo-500 focus:border-indigo-500"
            :placeholder="`Enter phone number with ${countryCode}`"
            required
          />
        </div>

        <div class="mb-4">
          <label for="channel" class="block text-sm font-medium text-gray-700">Channel:</label>
          <select v-model="channel" id="channel" class="w-full px-3 py-2 border border-gray-300 rounded-lg focus:ring-indigo-500 focus:border-indigo-500" required>
            <option value="sms">SMS</option>
            <option value="call">Call</option>
          </select>
        </div>

        <div class="mt-6">
          <button type="submit" class="w-full py-2 px-4 bg-indigo-600 text-white rounded-lg hover:bg-indigo-700 focus:ring-2 focus:ring-indigo-500">
            Send Verification
          </button>
        </div>
      </form>

      <p v-if="responseMessage" class="mt-4 text-center text-sm" :class="responseClass">
        {{ responseMessage }}
      </p>
      <!-- Already verified link -->
      <div class="mt-4 text-center">
        <p class="text-sm text-gray-500">
          Already verified?
          <a
            href="sign-in.html"
            class="text-indigo-600 hover:text-indigo-800 font-semibold"
            >Sign in</a
          >
        </p>
      </div>
    </div>
  </div>
</template>

<script>
import { useRouter } from 'vue-router';

export default {
  data() {
    return {
      phoneNumber: '',
      countryCode: '+62',  // Default country code (Indonesia)
      channel: 'sms',
      responseMessage: '',
      responseClass: '',
    };
  },
  watch: {
    countryCode(newCountryCode) {
      // Saat kode negara berubah, kita set phoneNumber menjadi kode negara saja terlebih dahulu
      if (!this.phoneNumber.startsWith(newCountryCode)) {
        this.phoneNumber = newCountryCode;  // Mengatur phoneNumber dengan kode negara baru
      }
    },
  },
  methods: {
    async sendVerification() {
      try {
        const response = await fetch('http://localhost:8080/api/verification/send', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify({
            phoneNumber: this.phoneNumber,
            channel: this.channel,
          }),
        });

        if (!response.ok) {
          throw new Error(`Error: ${response.statusText}`);
        }

        const data = await response.json();
        this.responseMessage = 'Verification sent successfully!';
        this.responseClass = 'text-green-500';

        // Simpan phoneNumber ke localStorage
        localStorage.setItem('phoneNumber', this.phoneNumber);

        // Redirect ke halaman verify
        this.$router.push({ path: '/verify' });
      } catch (error) {
        this.responseMessage = `Failed to send verification: ${error.message}`;
        this.responseClass = 'text-red-500';
      }
    },
  },
};
</script>

<style scoped>
/* Tambahkan gaya CSS sesuai kebutuhan */
</style>

